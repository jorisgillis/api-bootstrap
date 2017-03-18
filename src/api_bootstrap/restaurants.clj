(ns api-bootstrap.restaurants
  (:require [yesql.core :refer [defqueries]]))

(defqueries "sql/restaurants.sql")