; Exercise to time the primality test
; with a more sophisticated increment operation

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

(defn prime? [n]
  (= n (smallest-divisor n))
  )

(defn search-for-primes [n numberOfPrimes foundPrimes]
  (cond 
    (= numberOfPrimes foundPrimes) n
    (prime? n) 
      (do
        (println (str "found prime " n))
        (search-for-primes (+ n 1) numberOfPrimes (+ 1 foundPrimes)))
    :else
      (search-for-primes (+ n 1) numberOfPrimes foundPrimes))
  )

(defn time-prime-test [n]
  (def startTime (System/currentTimeMillis))
  (search-for-primes n 10 0)
  (println (str "Elapsed time " (- (System/currentTimeMillis) startTime)))
  )

(println "Time for 3 numbers larger than 1000")
(time-prime-test 1000)
(println "Time for 3 numbers larger than 10000")
(time-prime-test 10000)
(println "Time for 3 numbers larger than 100000")
(time-prime-test 100000)
(println "Time for 3 numbers larger than 1000000")
(time-prime-test 1000000)
(println "Time for 3 numbers larger than 10000000")
(time-prime-test 10000000)
(println "Time for 3 numbers larger than 100000000")
(time-prime-test 100000000)
