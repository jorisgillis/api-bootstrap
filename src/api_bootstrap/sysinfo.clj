(ns api-bootstrap.sysinfo
  (:require [api-bootstrap.endpoint :refer [make-api-handler]]
            [integrant.core :as ig]
            [compojure.core :refer :all]
            [ring.util.response :refer [response]]))

(def sysapi
  (routes
    (context "/system" []
             (GET "/info" []
                  (response "Up and running")))))

(defmethod ig/init-key :endpoint/sysinfo [_ _]
  (make-api-handler sysapi))
