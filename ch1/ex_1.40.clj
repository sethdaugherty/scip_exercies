; Exercise 1.40. Using Newton's method to approximate the roots of a cubic equation

; The fixed-point method is stolen from exercise 1.35
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

(defn cubic [a b c]
  (fn [x]
    (+ (Math/pow x 3)
       (* a
          (Math/pow x 2))
       (* b x)
       c)))

(def dx 0.0000001)

(defn derivative [func]
  (fn [x]
    (/ (- (func (+ x dx))
          (func x))
       dx)))

(defn newton-transform [func]
  (fn [x]
    (- x
       (/ (func x)
          ((derivative func) x))
    )))

(defn newtons-method [func guess]
  (fixed-point (newton-transform func) guess))

(newtons-method (cubic 2 1 1) 1)
