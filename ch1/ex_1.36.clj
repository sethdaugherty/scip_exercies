; Fixed point algorithm to solve x^x = 1000

(defn abs [x]
  (if (> 0.0 x) (- 0.0 x)
      x))

(def tolerance 0.00001)

(defn fixed-point [f first-guess]
  (defn close-enough? [val1 val2]
      (< (abs (- val1 val2))
       tolerance))
  (defn try_ [guess]
    (let [next (f guess)]
      (println "Guess was " guess )
      (if (close-enough? guess next) next
          (try_ next))))
  (try_ first-guess))

(defn transform [x]
  (+ 1.0 (/ 1.0 x)))

(defn log1000 [x]
  (/ (Math/log 1000) (Math/log x)))

(println (fixed-point log1000 1.01))

(defn -main
  [& args]
  (println "Value of x in x^x=1000")
  (println (fixed-point log1000 1.01)))
(-main)
