(ns api-bootstrap.crud
  (:require [api-bootstrap.endpoint :refer [make-api-handler]]
            [api-bootstrap.hotels :refer [fetch-hotels]]
            [api-bootstrap.db :refer [new-connection]]
            [integrant.core :as ig]
            [compojure.core :refer :all]
            [ring.util.response :refer [response]]))

(defn- make-handler [datasource]
  (routes
    (context "/" []
      (GET "/" []
        (response {:message "Hello world!"}))

      (context "/hotels/" []
        (GET "/" []
          (response (fetch-hotels {} (new-connection datasource))))))))


(defmethod ig/init-key :endpoint/crud [_ {datasource :datasource}]
  (make-api-handler (make-handler datasource)))
