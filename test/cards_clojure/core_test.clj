(ns cards-clojure.core-test
  (:require [clojure.test :refer :all]
            [cards-clojure.core :refer :all]))
(def hand-1 #{{:suit :clubs
               :rank 2}
              {:suit :clubs
               :rank 3}
              {:suit :clubs
               :rank :queen}
              {:suit :clubs
               :rank :king}})

(def hand-2 #{{:suit :diamonds
               :rank 2}
              {:suit :clubs
               :rank 3}
              {:suit :clubs
               :rank :queen}
              {:suit :clubs
               :rank :king}})
(deftest flush-test
  (testing "flush returns true if the hand is a flush"
    (is (= true (flush? hand-1)))
    (is (= false (flush? hand-2)))))


(def hand-3 #{{:suit :clubs
               :rank 2}
             {:suit :hearts
              :rank 2}
             {:suit :spades
              :rank 2}
             {:suit :diamonds
              :rank 2}})

(def hand-4 #{{:suit :clubs
               :rank 2}
              {:suit :hearts
               :rank 2}
              {:suit :spades
               :rank 3}
              {:suit :diamonds
               :rank 2}})

(deftest four-of-a-kind
  (testing "four-of-a-kind returns true if hand is four-of-a-kind"
    (is (= true (n-of-a-kind? 4 hand-3)))
    (is (= false (n-of-a-kind? 4 hand-4)))))

(def hand-5 #{{:suit :clubs
               :rank 2}
              {:suit :hearts
               :rank 2}
              {:suit :spades
               :rank 2}
              {:suit :diamonds
               :rank 4}})

(def hand-6 #{{:suit :clubs
               :rank 2}
              {:suit :hearts
               :rank 4}
              {:suit :spades
               :rank 3}
              {:suit :diamonds
               :rank 2}})

(deftest three-of-a-kind
  (testing "three-of-a-kind returns true if hand is three-of-a-kind"
    (is (= true (n-of-a-kind? 3 hand-5)))
    (is (= false (n-of-a-kind? 3 hand-6)))))

(def hand-7 #{{:suit :clubs
               :rank 2}
              {:suit :hearts
               :rank 2}
              {:suit :spades
               :rank 3}
              {:suit :diamonds
               :rank 3}})

(def hand-8 #{{:suit :clubs
               :rank 2}
              {:suit :hearts
               :rank 4}
              {:suit :spades
               :rank 3}
              {:suit :diamonds
               :rank 2}})

(deftest two-pair
  (testing "two-pair returns true if hand is two-pair"
    (is (= true (two-pair? hand-7)))
    (is (= false (two-pair? hand-8)))))

(def hand-9 #{{:suit :clubs
               :rank 2}
              {:suit :hearts
               :rank 3}
              {:suit :spades
               :rank 4}
              {:suit :diamonds
               :rank 5}})

(def hand-10 #{{:suit :clubs
               :rank 2}
              {:suit :hearts
               :rank 4}
              {:suit :spades
               :rank 3}
              {:suit :diamonds
               :rank 2}})

(deftest straight
  (testing "straight returns true if hand is straight"
    (is (= true (straight? hand-9)))
    (is (= false (straight? hand-10)))))