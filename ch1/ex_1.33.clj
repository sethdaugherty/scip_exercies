; Part A... iterative solution

; Exercise to time the primality test
; with a more sophisticated increment operation
; and a more sophisticated prime test (Fermat test)

(defn next-divisor [test-divisor]
  (if 
    (= 2 test-divisor) 3
    (+ 2 test-divisor)))

(defn find-divisor [n test-divisor]
    (cond (> (* test-divisor test-divisor) n) n
      (= 0 (rem n test-divisor)) test-divisor
      :else
        (find-divisor n (next-divisor test-divisor)))
  )


(defn smallest-divisor [n]
  (find-divisor n 2))

(defn square [x]
  (* x x))

(defn expmod [base exp n]
  (cond
    (= exp 0) 1
    (even? exp) 
      (rem 
        (square 
          (expmod base (/ exp 2) n)) 
        n)
    :else 
      (rem 
        (* base
           (expmod base (- exp 1) n))
        n)
    )
  ) 

(defn fermat-test [n]
  (let [
    try-it (fn [a]
      (= (expmod a n n) a))
    ]
    (try-it (+ 1 (rand-int (- n 1)))))
  )

(defn fast-prime? [n times]
  (cond 
    (= times 0) true
    (fermat-test n) (fast-prime? n (- times 1))
    :else
      false
  ))

(defn prime? [n]
  (fast-prime? n 100))

(defn filtered-accumulate [combiner filter term a next b]
  (defn iter [a result]
    (if (> a b) result
        (if (filter a)
                (iter (next a) (combiner (term a) result))
              (iter (next a) result))))
  (iter a 0))

(defn identity_ [num]
  num)

(defn increment [num]
  (+ num 1))

(defn multiply_ [num1 num2]
  (* num1 num2))

(defn find-next [num]
  (if (even? num) (/ (+ num 2) (+ num 1))
      (/ (+ num 1) (+ num 2))))

(println "Sum of squares of prime numbers between 2 and 5")
(println (filtered-accumulate + prime? square 2 increment 5))
