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
  ":(")

(defn seq= [seq1 seq2]
  ":(")

(defn find-first-index [pred a-seq]
  ":(")

(defn avg [a-seq]
  -1)

(defn parity [a-seq]
  ":(")

(defn fast-fibo [n]
  ":(")

(defn cut-at-repetition [a-seq]
  [":("])

