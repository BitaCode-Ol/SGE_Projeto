package ui;

import model.*;
import service.SGEService;
import java.util.Scanner;

public class Main {
    private static SGEService s = new SGEService();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Dados iniciais para teste (Garante que há dados para testes das Fases 2, 4 e 6)
        Curso c1 = s.cadastrarCursoPresencial("Engenharia de Software","ESW101",360,"Sala 201");
        s.cadastrarCursoEAD("Marketing Digital","MKD202",180,"Moodle");
        Professor p1 = s.cadastrarProfessor("Marina Silva","marina","123", "Sistemas","PROF123");
        Aluno a1 = s.cadastrarAluno("João Silva","joao","123","M001", c1);
        Aluno a2 = s.cadastrarAluno("Maria Santos","maria","123","M002", c1);
        Turma t1 = s.criarTurma("T01-ESW", p1, c1);
        t1.adicionarAluno(a1);
        t1.adicionarAluno(a2);

        System.out.println("--- BEM-VINDO AO SGE EDUCONNECT ---");
        System.out.println("Aluno: Bárbara Thauanny Aparecida Oliveira - Versão Final"); // Adicione seu nome para o Print!
        menu();
    }

    private static void menu(){
        while(true){
            System.out.println("\n--- SGE - Menu ---");
            System.out.println("1 Cadastrar Aluno");
            System.out.println("2 Cadastrar Professor");
            System.out.println("3 Cadastrar Curso Presencial (Fase 4)");
            System.out.println("4 Cadastrar Curso EAD (Fase 4)");
            System.out.println("5 Criar Turma (Fase 2)");
            System.out.println("6 Adicionar Aluno à Turma (Fase 2)");
            System.out.println("7 Registrar Avaliação (Fase 3: Encapsulamento)");
            System.out.println("8 Gerar Relatórios (Fase 6: Polimorfismo)");
            System.out.println("0 Sair");
            System.out.print("Escolha: ");
            String opt = sc.nextLine();

            try{
                switch(opt){
                    case "1": cadastrarAlunoUI(); break;
                    case "2": cadastrarProfessorUI(); break;
                    case "3": cadastrarCursoPresencialUI(); break;
                    case "4": cadastrarCursoEADUI(); break;
                    case "5": criarTurmaUI(); break;
                    case "6": adicionarAlunoATurmaUI(); break;
                    case "7": registrarAvaliacaoUI(); break;
                    case "8": gerarRelatoriosUI(); break;
                    case "0": System.out.println("Saindo..."); return;
                    default: System.out.println("Opção inválida");
                }
            }catch(Exception e){
                System.out.println("Erro: Entrada inválida. Tente novamente.");
            }
        }
    }

    // Métodos de UI (Os mesmos da resposta anterior, agora validados e completos)

    private static void cadastrarAlunoUI(){
        System.out.print("Nome: "); String nome = sc.nextLine();
        System.out.print("Login: "); String login = sc.nextLine();
        System.out.print("Senha: "); String senha = sc.nextLine();
        System.out.print("Matrícula: "); String mat = sc.nextLine();
        System.out.print("Código do curso: "); String cod = sc.nextLine();
        Curso cur = s.cursoRepo.buscarPorCodigo(cod);
        if(cur == null) { System.out.println("Curso não encontrado."); }
        Aluno a = s.cadastrarAluno(nome, login, senha, mat, cur);
        System.out.println("✅ Aluno cadastrado: " + a.getNome());
    }

    private static void cadastrarProfessorUI(){
        System.out.print("Nome: "); String nome = sc.nextLine();
        System.out.print("Login: "); String login = sc.nextLine();
        System.out.print("Senha: "); String senha = sc.nextLine();
        System.out.print("Especialidade: "); String esp = sc.nextLine();
        System.out.print("Registro: "); String reg = sc.nextLine();
        Professor p = s.cadastrarProfessor(nome, login, senha, esp, reg);
        System.out.println("✅ Professor cadastrado: " + p.getNome());
    }

    private static void cadastrarCursoPresencialUI(){
        try {
            System.out.print("Nome do curso: "); String nome = sc.nextLine();
            System.out.print("Código: "); String cod = sc.nextLine();
            System.out.print("Carga horária: "); int ch = Integer.parseInt(sc.nextLine());
            System.out.print("Sala: "); String sala = sc.nextLine();
            s.cadastrarCursoPresencial(nome, cod, ch, sala);
            System.out.println("✅ Curso presencial cadastrado. (Fase 4)");
        } catch (NumberFormatException e) { System.out.println("❌ Carga horária inválida."); }
    }

    private static void cadastrarCursoEADUI(){
        try {
            System.out.print("Nome do curso: "); String nome = sc.nextLine();
            System.out.print("Código: "); String cod = sc.nextLine();
            System.out.print("Carga horária: "); int ch = Integer.parseInt(sc.nextLine());
            System.out.print("Plataforma: "); String pl = sc.nextLine();
            s.cadastrarCursoEAD(nome, cod, ch, pl);
            System.out.println("✅ Curso EAD cadastrado. (Fase 4)");
        } catch (NumberFormatException e) { System.out.println("❌ Carga horária inválida."); }
    }

    private static void criarTurmaUI(){
        System.out.print("Código da turma: "); String cod = sc.nextLine();
        System.out.print("Login do professor: "); String login = sc.nextLine();
        Professor p = s.profRepo.buscarPorLogin(login);
        System.out.print("Código do curso: "); String codCurso = sc.nextLine();
        Curso c = s.cursoRepo.buscarPorCodigo(codCurso);

        if(p==null || c==null){
            System.out.println("❌ Professor ou curso não encontrados. Turma não criada.");
            return;
        }
        s.criarTurma(cod, p, c);
        System.out.println("✅ Turma criada: " + cod + " (Fase 2)");
    }

    private static void adicionarAlunoATurmaUI(){
        System.out.print("Código da turma: "); String cod = sc.nextLine();
        Turma t = s.turmaRepo.buscarPorCodigo(cod);
        System.out.print("Matrícula do aluno: "); String mat = sc.nextLine();
        Aluno a = s.alunoRepo.buscarPorMatricula(mat);

        if(t==null || a==null){
            System.out.println("❌ Turma ou aluno não encontrados.");
            return;
        }
        t.adicionarAluno(a);
        System.out.println("✅ Aluno adicionado à turma.");
    }

    private static void registrarAvaliacaoUI(){
        try {
            System.out.print("Matrícula do aluno: "); String mat = sc.nextLine();
            Aluno a = s.alunoRepo.buscarPorMatricula(mat);
            if(a==null){ System.out.println("❌ Aluno não encontrado."); return; }

            System.out.print("Descrição da avaliação: "); String desc = sc.nextLine();
            Avaliacao av = new Avaliacao(desc);

            System.out.print("Nota (0-10): "); double nota = Double.parseDouble(sc.nextLine());

            if(av.atribuirNota(nota)){
                a.adicionarAvaliacao(av);
                System.out.println("✅ Avaliação registrada. (Fase 3: Nota validada)");
            } else {
                System.out.println("❌ Nota inválida. Deve ser entre 0 e 10. (Fase 3: Falha na validação)");
            }
        } catch (NumberFormatException e) { System.out.println("❌ Nota inválida. Digite um número."); }
    }

    private static void gerarRelatoriosUI(){
        System.out.println("\n--- Gerar Relatórios (Fase 6) ---");
        System.out.println("1 - Alunos");
        System.out.println("2 - Professores");
        System.out.println("3 - Cursos (Mostra Presencial/EAD)");
        System.out.println("4 - Resumo de Turmas");
        System.out.print("Escolha: ");
        String o = sc.nextLine();

        switch(o){
            case "1": s.alunoRepo.listar().forEach(Aluno::gerarRelatorio); break;
            case "2": s.profRepo.listar().forEach(Professor::gerarRelatorio); break;
            case "3": s.cursoRepo.listar().forEach(Curso::gerarRelatorio); break; // Polimorfismo
            case "4": s.turmaRepo.listar().forEach(Turma::mostrarResumo); break;
            default: System.out.println("Opção inválida");
        }
    }

}
