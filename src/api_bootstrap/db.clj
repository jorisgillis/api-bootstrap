(ns api-bootstrap.db
  (:require [clojure.java.jdbc :as jdbc]))

(defn new-connection [datasource]
  {:connection {:datasource datasource}})

(defn with-transaction [fn datasource]
  (let [connection (new-connection datasource)]
    (jdbc/with-db-transaction
      [connection datasource]
      (fn connection))))
