(ns api-bootstrap.crud
  (:require [api-bootstrap.endpoint :refer [make-api-handler]]
            [integrant.core :as ig]
            [compojure.core :refer :all]
            [ring.util.response :refer [response]]))

(defroutes
  api
  (context "/" []
           (GET "/" []
                (response {:message "Hello world!"}))))


(defmethod ig/init-key :endpoint/crud [_ _]
  (make-api-handler api))
