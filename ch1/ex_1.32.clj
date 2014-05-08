; Part A... iterative solution

(defn accumulate [combiner term a next b]
  (defn iter [a result]
    (if (> a b) result
        (iter (next a) (combiner (term a) result))))
  (iter a 1))

(defn identity_ [num]
  num)

(defn increment [num]
  (+ num 1))

(defn multiply_ [num1 num2]
  (* num1 num2))

(defn find-next [num]
  (if (even? num) (/ (+ num 2) (+ num 1))
      (/ (+ num 1) (+ num 2))))

(println "Product of numbers between 1 and 5")
(println (accumulate multiply_ identity_ 1 increment 5))

(println "Approximation of pi/4 using the formula:")
(println (* 4.0 (accumulate multiply_ find-next 1 increment 100)))



; Part B... Recursive implementation

(defn accumulate-recur [combiner term-fn a next-fn b]
  (if (> a b) 1
      (combiner (term-fn a)
         (accumulate-recur combiner term-fn (next-fn a) next-fn b))))

(println "\n*********************************\n")
(println "Part B: recursive solution")

(println "Product of numbers between 1 and 5")
(println (accumulate-recur multiply_ identity_ 1 increment 5))

(println "Approximation of pi/4 using the formula:")
(println (* 4.0 (accumulate-recur multiply_ find-next 1 increment 100)))

