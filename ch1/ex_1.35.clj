; Golden ratio with the fixed point algorithm

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
      (if (close-enough? guess next) next
          (try_ next))))
  (try_ first-guess))

(defn transform [x]
  (+ 1.0 (/ 1.0 x)))

(defn -main
  [& args]
  (println "Value of golden ratio:")
  (println (fixed-point transform 0.01)))
(-main)
