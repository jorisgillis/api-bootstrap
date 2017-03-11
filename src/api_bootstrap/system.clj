(ns api-bootstrap.system
  (:require [api-bootstrap.crud]
            [api-bootstrap.sysinfo]
            [compojure.core :refer [routes]]
            [ring.adapter.jetty :refer [run-jetty]]
            [integrant.core :as ig]))

(def system-config
  {:adapter/jetty    {:port    8000
                      :handler (ig/ref :handler)
                      :join?   false}
   :handler          {:endpoints [(ig/ref :endpoint/sysinfo) (ig/ref :endpoint/crud)]}
   :endpoint/sysinfo {}
   :endpoint/crud    {}})

(defmethod ig/init-key :handler [_ {:keys [endpoints]}]
  (apply routes endpoints))

(defmethod ig/init-key :adapter/jetty [_ {:keys [port handler join?]}]
  (run-jetty handler {:join? join?
                      :port  port}))
