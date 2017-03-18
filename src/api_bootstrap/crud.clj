(ns api-bootstrap.crud
  (:require [api-bootstrap.endpoint :refer [make-api-handler]]
            [api-bootstrap.restaurants :refer [get-all-restaurants]]
            [integrant.core :as ig]
            [compojure.core :refer :all]
            [ring.util.response :refer [response]]))

(defn make-handler [datasource]
  (routes
    (context "/" []
      (GET "/" []
        (response {:message "Hello world!"}))

      (context "/restaurants/" []
        (GET "/" []
          (response {:restaurants (get-all-restaurants datasource)}))))))


(defmethod ig/init-key :endpoint/crud [_ {datasource :datasource}]
  (make-api-handler (make-handler datasource)))
