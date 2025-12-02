# Sistema de Gestão Educacional (SGE) 

##  Informações da Atividade

* **Disciplina:** Programação Orientada a Objetos (POO)
* **Aluno(a):** Bárbara Thauanny Aparecida Oliveira 
* **Matrícula:** 24102561-5
* **Período:** 2025/54

## Objetivos do Projeto

Este sistema foi desenvolvido em Java puramente no console para aplicar e demonstrar os principais pilares da Programação Orientada a Objetos (POO) e Arquitetura em Camadas.

O sistema simula um ambiente de gestão de dados acadêmicos, permitindo o cadastro de usuários, cursos, turmas e avaliações.

## Pilares da POO Implementados

O projeto está dividido em fases conceituais, onde cada uma demonstra um pilar específico:

| Conceito (Fase) | Classes Envolvidas | Demonstração |
| :--- | :--- | :--- |
| **Fase 2: Associações** | `Turma`, `Aluno`, `Professor`, `Curso` | Relacionamento de 1 para N (Turma contém múltiplos Alunos). |
| **Fase 3: Encapsulamento** | `Avaliacao` | Proteção do atributo `nota` com validação de limites (0 a 10) no método `atribuirNota()`. |
| **Fase 4: Herança** | `CursoPresencial`, `CursoEAD` | Subclasses que herdam de `Curso` e adicionam atributos específicos (`sala` ou `plataforma`). |
| **Fase 5: Abstração/Interface** | `Usuario`, `Autenticacao` | Uso de classes **abstratas** e **interfaces** para definir a estrutura de login e autenticação. |
| **Fase 6: Polimorfismo** | Métodos `gerarRelatorio()`, `detalharCurso()` | Permite que uma mesma chamada liste dados diferentes, como o detalhamento correto de um Curso Presencial ou EAD. |
| **Fase 7: Arquitetura** | `model`, `repository`, `service`, `ui` | O código é dividido em pacotes (camadas) para separação de responsabilidades. |

## Como Executar o Projeto

O projeto utiliza apenas Java padrão (JDK) e pode ser executado via terminal (prompt de comando).

1.  **Clone o Repositório:**
    ```bash
    git clone [https://docs.github.com/pt/migrations/importing-source-code/using-the-command-line-to-import-source-code/adding-locally-hosted-code-to-github](https://docs.github.com/pt/migrations/importing-source-code/using-the-command-line-to-import-source-code/adding-locally-hosted-code-to-github)
    ```

2.  **Acesse a Pasta:**
    ```bash
    cd [Nome do Seu Repositório, ex: SGE_Projeto]
    ```

3.  **Compilar e Executar:**
    ```bash
    # 1. Compilação (cria a pasta 'out'
