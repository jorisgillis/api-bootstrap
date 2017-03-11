(ns api-bootstrap.main
  (:gen-class)
  (:require [integrant.core :as ig]
            [api-bootstrap.system :refer [system-config]]))

(defn- adapt-system-config-for-standalone-run []
  (->
    system-config
    (assoc-in [:adapter/jetty :join?] true)))

(defn -main [& args]
  (ig/init (adapt-system-config-for-standalone-run)))
