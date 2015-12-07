(ns looping-is-recursion)

(defn power [base exp]
  (let [helper (fn [acc base exp]
                 (if (zero? exp)
                   acc ; mezivysledek danej
                   ; musi mit stejnej pocet param jako volana funkce
                   (recur (* acc base) base (dec exp))))]
    (helper 1 base exp)
  ))


(defn last-element [a-seq]
(let [helper (fn [acc a-seq]
                 (if (empty? (rest a-seq))
                   (first a-seq) ; mezivysledek danej
                   ; musi mit stejnej pocet param jako volana funkce
                   (recur acc (rest a-seq))))]
    (helper nil a-seq)
  ))

(defn seq= [seq1 seq2]
  (if (= (count seq1) (count seq2))
    (if (= 0 (count seq1)) true
      (let [helper (fn [acc a-seq b-seq]
                     (if (empty? a-seq)
                       acc
                       (recur
                        (if (= acc true) (= (first a-seq) (first b-seq)) false)
                          (rest a-seq) (rest b-seq))))]
        (helper true seq1 seq2)
       ))
    false
  ))

(defn find-first-index [pred a-seq]
  (loop [acc 0 rest-seq a-seq]
    (if (empty? rest-seq) nil
      (if (pred (first rest-seq)) acc
        (recur (inc acc) (rest rest-seq)))
  )))

(defn avg [a-seq]
  (loop [n 0 cnt 0 rq a-seq]
    (if (empty? rq) (if (= 0 cnt) 0 (/ n cnt))
      (recur (+ (first rq) n) (inc cnt) (rest rq))
)))

(defn parity [a-seq]
  (loop [newset #{} rq a-seq]
    (if (empty? rq) newset
      (recur (if (contains? newset (first rq))
               (disj newset (first rq))
               (conj newset (first rq)))
             (rest rq))
  )))


(defn fast-fibo [n]
  (loop [step 0
         prev 1 ;Fn-1
         cnt 0] ; Fn
    ; v tomhle ifu je zahrnutej nultej krok
    (if (= step n) cnt
      ; prev se posle jako aktualni, aktualni je soucet
      (recur (inc step) cnt (+ cnt prev))))
  )

(defn cut-at-repetition [a-seq]
  (loop [nq []
         sq a-seq]
    (if (empty? sq) nq
      (if (not= (find-first-index (fn [n] (= n (first sq))) nq) nil) nq
        (recur (conj nq (first sq)) (rest sq)))))
)
