/*script typescript que não é um componente
?? operador de coalescência nula, do lado direito do ?? é o valor padrão da variável
e do lado esquerdo do ?? é pego alternativamente a variável ambiente
lê-se assim: pega o valor da variável de ambiente, mas se não existri o valor da variável de ambiente
então por padrão utilize "http://localhost:8080", assim podeos utilizar a vaiável BASE_URL invés de ficar
passando o endereço */
export const BASE_URL = import.meta.env.VITE_BACKEND_URL ?? "http://localhost:8080";