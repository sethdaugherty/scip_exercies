; Implementation of Simpson's rule to approximate the integral of functions

(defn determine-coefficient 
  [iteration totalIterations]
  (cond
    (= 0 iteration) 1
    (= iteration totalIterations) 1
    (even? iteration) 4
    :else 2))

(defn y [f a k h]
  (f (+ a
        (* k h))))

(defn simpsons-rule-iter
  [f lowerBound upperBound iterations totalIterations]
  (let [h (/ (- upperBound lowerBound)
          totalIterations)]
    (cond 
      (> iterations totalIterations) 0
      :else 
        (+ (* (/ h 3)
              (* (determine-coefficient iterations totalIterations)
                 (y f lowerBound iterations h)))
           (simpsons-rule-iter f 
                               lowerBound 
                               upperBound 
                               (+ iterations 1)
                               totalIterations)))))

(defn simpsons-rule
  [f lowerBound upperBound iterations]
  (simpsons-rule-iter f lowerBound upperBound 0 iterations))

(defn cube [x]
  (* x x x))

(println "Integral of f between 0 and 1 for n=100")
(println (simpsons-rule cube 0 1.0 100))
(println "Integral of f between 0 and 1.0 for n=1000")
(println (simpsons-rule cube 0 1.0 1000))

