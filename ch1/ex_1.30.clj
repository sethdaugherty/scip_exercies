(defn sum [term a next b]
  (defn iter [a result]
    (println a result)
    (if (> a b) result
        (iter (next a) (+ (term a) result))))
  (iter a 0))

(defn cube [num]
  (* num num num))

(defn increment [num]
  (+ num 1))

(println "Sum of cubes between 1^3 and 10^3")
(println (sum cube 1 increment 10))
