(ns estoque.aula4)
(def precos [30 700 1000])

(println (precos 0))
(println (get precos 0))
(println (get precos 1))
(println (get precos 2))
;(println (precos 10))
(println "Valor padrao" (get precos 10 0))

(println (conj precos 5))
(println precos)

(println (inc 5))
(println (update precos 0 inc))
(println (update precos 1 dec))
(println precos)

(println "Update manual")
(defn soma-1
  [valor]
  (println "Estou somando um" valor)
  (+ valor 1))

(println (update precos 0 soma-1))

(defn soma-3
  [valor]
  (println "Estou somando 3")
  (+ valor 3))

(println (update precos 0 soma-3))



(defn aplica-desconto?
  [valor-bruto]
  (> valor-bruto 100))

(defn valor-descontado
  "Retorna o valor com desconto de 10%"
  [valor-bruto]
  (if (aplica-desconto? valor-bruto)
    (let [taxa-de-desconto (/ 10 100)
          desconto (* valor-bruto taxa-de-desconto)]
      (- valor-bruto desconto))
    valor-bruto))

(println (map valor-descontado precos))

(println (range 10))
(println (filter even? (range 10)))

(println "Vetor" precos)
(println "Filter" (filter aplica-desconto? precos))

(println "Map apos o filter" (map valor-descontado (filter aplica-desconto? precos)))

(println "Vetor" precos)
(println (reduce + precos))

(defn minha-soma
  [valor-1 valor-2]
  (println "Somando" valor-1 valor-2)
  (+ valor-1 valor-2))

(println (reduce minha-soma precos))
(println (reduce minha-soma (range 10)))

(println (reduce minha-soma 0 precos))
(println (reduce minha-soma 0 (range 10)))
(println (reduce minha-soma 0 [15]))
(println (reduce minha-soma 0 []))