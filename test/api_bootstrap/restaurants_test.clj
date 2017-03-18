(ns api-bootstrap.restaurants-test
  (:use [midje.sweet])
  (:require [api-bootstrap.restaurants :refer :all]
            [api-bootstrap.db :refer [new-connection]]))

(fact "fetch restaurants from database"
      (get-all-restaurants :datasource) => [{:id 1 :name "Figaro"}]
      (provided
        (new-connection :datasource) => :connection
        (fetch-restaurants {} :connection) => [{:id 1 :name "Figaro"}]))
