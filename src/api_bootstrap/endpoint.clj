(ns api-bootstrap.endpoint
  (:require [ring.middleware.defaults :refer :all]
            [ring.middleware.json :refer :all]))

(defn make-api-handler [routes]
  (->
    routes
    wrap-json-response
    (wrap-json-body {:keywords? true})
    (wrap-defaults api-defaults)))