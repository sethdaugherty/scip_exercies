; Part A... iterative solution

(defn product [term a next b]
  (defn iter [a result]
    (if (> a b) result
        (iter (next a) (* (term a) result))))
  (iter a 1))

(defn identity_ [num]
  num)

(defn increment [num]
  (+ num 1))

(defn find-next [num]
  (if (even? num) (/ (+ num 2) (+ num 1))
      (/ (+ num 1) (+ num 2))))

(println "Product of numbers between 1 and 5")
(println (product identity_ 1 increment 5))

(println "Approximation of pi/4 using the formula:")
(println (* 4.0 (product find-next 1 increment 100)))



; Part B... Recursive implementation

(defn product-recur [term-fn a next-fn b]
  (if (> a b) 1
      (* (term-fn a)
         (product-recur term-fn (next-fn a) next-fn b))))

(println "\n*********************************\n")
(println "Part B: recursive solution")

(println "Product of numbers between 1 and 5")
(println (product-recur identity_ 1 increment 5))

(println "Approximation of pi/4 using the formula:")
(println (* 4.0 (product-recur find-next 1 increment 100)))

