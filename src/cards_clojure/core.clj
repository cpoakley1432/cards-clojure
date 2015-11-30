(ns cards-clojure.core
  (:gen-class))

(def suits [:clubs :spades :hearts :diamonds])
(def ranks (range 1 14))
(def rank-names {1 :ace, 11 :jack, 12 :queen, 13 :king})

(defn create-deck []
  (set (for [suit suits
             rank ranks]
         {:suit suit
          :rank (get rank-names rank rank)})))
(defn create-hands [deck]
  (set (for [c1 deck
         c2 (disj deck c1)
         c3 (disj deck c1 c2)
         c4 (disj deck c1 c2 c3)]
     #{c1 c2 c3 c4})))

(defn flush? [hand]
  (= 1 (count (set (map :suit hand)))))

(defn numbers [hand]
  (sort > (map second (frequencies (map second hand)))))

(defn n-of-a-kind? [n hand]
  (= n (first (numbers hand))))

(defn two-pair? [hand]
  (= '(2 2) (take 2 (numbers hand))))

(defn straight? [hand]
  (let [[min-value :as sorted] (sort (map :rank hand))] (= sorted (take 4 (iterate inc min-value)))))

(defn -main [& args]
  (time (let [deck (create-deck)
         hands (create-hands deck)
         hands (filter flush? hands)
         hands (filter n-of-a-kind? hands)
         hands (filter two-pair? hands)
         hands (filter straight? hands)]
     println (count hands))))
