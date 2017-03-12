(ns api-bootstrap.hotels
  (:require [yesql.core :refer [defqueries]]))

(defqueries "sql/hotels.sql")