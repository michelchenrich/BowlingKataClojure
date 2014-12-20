(ns bowling)

(defn- strike? [rolls]
  (= 10 (first rolls)))

(defn- spare? [rolls]
  (= 10 (+ (first rolls) (second rolls))))

(defn- drop-frame [rolls]
  (let [rolls-in-frame (if (strike? rolls) 1 2)]
    (drop rolls-in-frame rolls)))

(defn- calculate-frame [rolls]
  (let [rolls-to-sum (if (or (strike? rolls) (spare? rolls)) 3 2)]
    (reduce + (take rolls-to-sum rolls))))

(defn score [rolls]
  (loop [rolls rolls, score 0, frame 0]
    (if (= 10 frame)
      score
      (recur (drop-frame rolls)
             (+ (calculate-frame rolls) score)
             (inc frame)))))