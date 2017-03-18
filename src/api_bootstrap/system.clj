(ns api-bootstrap.system
  (:require [api-bootstrap.crud]
            [api-bootstrap.sysinfo]
            [compojure.core :refer [routes]]
            [ring.adapter.jetty :refer [run-jetty]]
            [integrant.core :as ig]
            [hikari-cp.core :refer [make-datasource close-datasource]]))

(def system-config
  {:adapter/jetty    {:port    8000
                      :handler (ig/ref :handler)
                      :join?   false}
   :handler          {:endpoints [(ig/ref :endpoint/sysinfo) (ig/ref :endpoint/crud)]}
   :endpoint/sysinfo {}
   :endpoint/crud    {:datasource (ig/ref :datasource)}
   :datasource       {:adapter       "mariadb"
                      :database-name "restaurants"
                      :username      "root"
                      :password      ""
                      :server-name   "127.0.0.1"
                      :port-number   3306}})

(defmethod ig/init-key :handler [_ {:keys [endpoints]}]
  (apply routes endpoints))

(defmethod ig/init-key :adapter/jetty [_ {:keys [port handler join?]}]
  (run-jetty handler {:join? join?
                      :port  port}))

(defmethod ig/halt-key! :adapter/jetty [_ server]
  (.stop server)
  (.join server))

(defmethod ig/init-key :datasource [_ config]
  (make-datasource config))

(defmethod ig/halt-key! :datasource [_ datasource]
  (close-datasource datasource))