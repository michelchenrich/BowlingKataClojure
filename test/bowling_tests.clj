(ns bowling-tests
  (:use clojure.test)
  (:use bowling))

(deftest no-score-in-game
  (is (= 0 (score [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0]))))

(deftest simple-game
  (is (= 20 (score [1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1]))))

(deftest spare-game
  (is (= 20 (score [7 3 4 2 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0]))))

(deftest strike-game
  (is (= 46 (score [10 10 4 2 0 0 0 0 0 0 0 0 0 0 0 0 0 0]))))

(deftest perfect-game
  (is (= 300 (score [10 10 10 10 10 10 10 10 10 10 10 10]))))

(deftest all-spares
  (is (= 150 (score [5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5]))))

(run-tests 'bowling-tests)