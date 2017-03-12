(ns user
  (:require [integrant.repl :refer [config system prep init go halt clear reset reset-all]]
            [api-bootstrap.system :refer [system-config]]))

(defn- load-config []
  system-config)

(integrant.repl/set-prep! load-config)
