; Iterative implementation of the O(log(n)) exponentiation function

(defn fast-exp-iter [base exponent a]
  (println base exponent a)
  (cond
    (= exponent 0) a
    (even? exponent) (fast-exp-iter (* base base) (/ exponent 2) a)
    :else
      (fast-exp-iter base (- exponent 1) (* a base)))
)

(defn fast-exp [base exponent]
  (fast-exp-iter base exponent 1))

(println "1^1: ")
(println (fast-exp 1 1))
(println "1^2: ")
(println (fast-exp 1 2))
(println "1^3: ")
(println (fast-exp 1 3))
(println "2^1: ")
(println (fast-exp 2 1))
(println "2^2: ")
(println (fast-exp 2 2))
(println "2^3: ")
(println (fast-exp 2 3))
(println "2^4: ")
(println (fast-exp 2 4))
(println "2^5: ")
(println (fast-exp 2 5))
(println "2^6: ")
(println (fast-exp 2 6))
