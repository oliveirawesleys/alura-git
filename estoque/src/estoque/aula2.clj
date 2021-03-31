(ns estoque.aula2)

(defn valor-descontado
  "Retorna o valor descontado que é 90% do valor bruto."
  [valor-bruto]
  (* valor-bruto 0.9))

(println
  (valor-descontado 100))