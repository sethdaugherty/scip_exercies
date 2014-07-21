; Exercise 1.43; Smoothing function using the average of f(x - dx), f(x), and f(x + dx)

(defn repeated [func numberOfRepeats]
  (repeated-iter func numberOfRepeats func))

(defn repeated-iter [func numberOfRepeats partialFunc]
  (if (= 1 numberOfRepeats)
    partialFunc
    (repeated-iter func
                   (- numberOfRepeats 1)
                   (fn [x] (func (partialFunc x))))))

(defn average [numbers]
  (/ (apply + numbers) (count numbers)))

(def dx 0.001)

(defn smooth [func]
  (fn [x]
    (average [(func (- x dx))
              (func x)
              (func (+ x dx))])))

(defn nfold-smooth [func n]
  (repeated (smooth func) n))
