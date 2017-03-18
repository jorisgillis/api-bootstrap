(ns api-bootstrap.restaurants
  (:require [yesql.core :refer [defqueries]]
            [api-bootstrap.db :refer [new-connection]]))

(defqueries "sql/restaurants.sql")

(defn get-all-restaurants [datasource]
  (fetch-restaurants {} (new-connection datasource)))