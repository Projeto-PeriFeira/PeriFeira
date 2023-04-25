<div align="center">
<img src="https://media-public.canva.com/C0TRw/MAE3u6C0TRw/1/tl.png" width=90px>

# Projeto Integrador - Perifeira
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![MySQL](https://img.shields.io/badge/mysql-%2300f.svg?style=for-the-badge&logo=mysql&logoColor=white)
![React](https://img.shields.io/badge/react-%2320232a.svg?style=for-the-badge&logo=react&logoColor=%2361DAFB)
![HTML5](https://img.shields.io/badge/html5-%23E34F26.svg?style=for-the-badge&logo=html5&logoColor=white)
![CSS3](https://img.shields.io/badge/css3-%231572B6.svg?style=for-the-badge&logo=css3&logoColor=white)
![JavaScript](https://img.shields.io/badge/javascript-%23323330.svg?style=for-the-badge&logo=javascript&logoColor=%23F7DF1E)

![Acessos](https://api.visitorbadge.io/api/visitors?path=https%3A%2F%2Fgithub.com%2FProjeto-Integrador-Generation%2Fprojeto-integrador&label=A%20C%20E%20S%20S%20O%20S&labelColor=%2320232a&countColor=%2320232a&labelStyle=upper)

[Sobre o tema](#sobre-o-tema) •
[📑 Funcionalidades](#-funcionalidades) •
[📽 Execução](#-execução) •
[💻 Desenvolvedores](#-desenvolvedores) •
[📏 Organização do Projeto](#-organização-do-projeto)

Este projeto faz parte da finalização do Bloco 2 e 3 do Bootcamp Full-Stack Java da turma 63 [Generation Brasil](https://brazil.generation.org/).

</div>



Aplicamos os conceitos de:
- Laços Condicionais
- Laços de Repetição
- Métodos e Modificadores de acesso
- Classes, Atributos e Objetos       
- Herança
- Collections
- Exceptions

# Sobre o tema

<div align="center">

<frase conceitual do projeto>

</div>

## 📑 Funcionalidades
<funcoes>

## Sobre o desenvolvimento do sistema
Sistema desenvolvido em Java utilizando os conceitos de Programação Orientada a Objetos (POO), Banco de Dados MySQL e o framework Spring.

## 📽 Execução
<gif>
 
### 💻 Desenvolvedores
[<img src="https://avatars.githubusercontent.com/u/127500150?v=4" width=170 > <br> <sub> Graziela </sub>](https://github.com/HeiGrazi) | [<img src="https://avatars.githubusercontent.com/u/127527831?v=4" width=170 > <br> <sub> Igor Menezes </sub>](https://github.com/IgorWz) | [<img src="https://avatars.githubusercontent.com/u/112830319?v=4" width=170 > <br> <sub> Jéssica Mendes </sub>](https://github.com/JesscMendesr) | [<img src="https://avatars.githubusercontent.com/u/127769948?v=4" width=170 > <br> <sub> Jonatas Nascimento </sub>](https://github.com/nascimentojon) | [<img src="https://avatars.githubusercontent.com/u/82914094?v=4" width=170 > <br> <sub> Larissa Pimenta </sub>](https://github.com/LarissaMarquesPimenta) | [<img src="https://avatars.githubusercontent.com/u/115853196?s=96&v=4" width=170 > <br> <sub> Renato Nunes </sub>](https://github.com/renatonunes74) |
| :---: | :---: | :---: | :---: | :---: | :---: |

#### 💟 Agradecimentos
**É o Grupo 4!**
 <agradecimento>
 🍰🍵

## 📏 Organização do projeto
```
 📁 pefireira
   |- 📁 src
   |   |- 📁 application
   |   |    |- 📑 Menu.java
   |   |- 📁 model
   |   |    |- 📑 Estoque.java
   |   |    |- 📑 Ong.java
   |   |    |- 📑 Pessoa.java
   |   |- 📁 assets
   |   |    |- 📑 diagrama_classes.pu
   |   |    |- 📑 diagrama_classes.png
   |   |    |- 📑 caso_de_uso.pu
   |   |    |- 📑 caso_de_uso.png
   |   |    |- 📑 eap.pu
   |   |    |- 📑 eap.pnp
   |- 📑 .gitignore
   |- 📑 README.md
```

### Diagrama de entidade e relacionamento
```mermaid
erDiagram
    tb_categorias {
        id BIGINT
        descricao VARCHAR(255)
    }

   	tb_produtos {
		BIGINT id
		VARCHAR(255) nome
		descricao VARCHAR(255)
		BIGINT quantidade 
		DECIMAL(82) preco 
		VARCHAR(255) foto
		tb_categorias_id BIGINT
		tb_usuario_id BIGINT
    }

    tb_usuario {
		id BIGINT
		usuario VARCHAR(255)
		nome VARCHAR(255)
		senha VARCHAR(255)
		cep BIGINT(8)
		cpf BIGINT(11)
		endereco VARCHAR(255)
		foto VARCHAR(255)
	}

    tb_categorias ||--o{ tb_produtos : contem
    tb_usuario ||--o{ tb_produtos : contem
 ```
### EAP
```mermaid
graph TD
A[Produtos] --> B[Sacola]
A --> C[Cesta]
C --> D[Tamanhos]
D --> E[Pequeno]
D --> F[Grande]
D --> G[Médio]
B --> H[Avulso]
C --> I[Tipos]
I --> J[Surpresa]
```
### Caso de Uso
![Caso de Uso](https://github.com/Projeto-Integrador-Generation/projeto-integrador/blob/main/assets/caso_de_uso.png)
