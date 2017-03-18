(ns api-bootstrap.crud-test
  (:use [midje.sweet]
        [peridot.core])
  (:require [api-bootstrap.crud :refer :all]
            [api-bootstrap.restaurants :as restaurants]
            [clojure.data.json :refer [read-str]]))

(fact "returns list of JSON objects"
      (let [datasource  :datasource
            response    (delay (->
                                 (session (make-handler datasource))
                                 (request "/restaurants/")
                                 :response))
            restaurants [{:id 1 :name "Figaro"}]]
        (:status @response) => 200
        (provided
          (restaurants/get-all-restaurants :datasource) => restaurants)
        (:body @response) => {:restaurants restaurants}))
