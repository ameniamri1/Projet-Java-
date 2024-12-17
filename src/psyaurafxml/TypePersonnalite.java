package psyaurafxml;


public class TypePersonnalite {

    private String type;
    private String description;

    public TypePersonnalite(String type, int score) {
        this.type = type;
        this.description = genererDescription(type, score);
    }

    public TypePersonnalite(String type) {
        this.type = type;
        
    }

    public TypePersonnalite(String type, String description) {
        this.type = type;
        this.description = description;
    }
    
    
    

    // Génère une description adaptée selon le type et le score
    public String genererDescription(String type, int score) {
        return switch (type) {
            case "Optimisme" -> {
                if (score >= 5) {
                    yield "Vous possédez un optimisme exceptionnel, ce qui vous aide à maintenir une grande résilience face aux défis. Vous voyez des opportunités même dans les épreuves.";
                } else if (score >= 3) {
                    yield "Vous êtes optimiste de nature, mais vous pourriez parfois être plus attentif aux risques potentiels dans certaines situations.";
                } else if (score >= 1) {
                    yield "Votre optimisme est modéré, ce qui peut vous rendre équilibré dans vos jugements, mais cela pourrait limiter votre capacité à prendre des risques.";
                } else {
                    yield "Votre optimisme est faible, ce qui pourrait vous faire ressentir des hésitations face à l'incertitude. Développer une approche plus positive pourrait améliorer votre bien-être.";
                }
            }
            case "Pessimisme" -> {
                if (score <= -5) {
                    yield "Votre pessimisme élevé vous pousse à éviter les risques, mais il peut également vous exposer à des états de stress chronique. Vous pourriez bénéficier de techniques de gestion du stress.";
                } else if (score <= -3) {
                    yield "Votre perception pessimiste vous aide à anticiper les problèmes, mais il est important de ne pas négliger les opportunités positives.";
                } else if (score >= 0) {
                    yield "Votre tendance au pessimisme est légère, ce qui peut vous rendre prudent tout en laissant place à des approches constructives.";
                } else {
                    yield "Vous êtes très peu pessimiste, ce qui est une force, mais soyez attentif à ne pas ignorer complètement les éventuels dangers.";
                }
            }
            case "Confiance" -> {
                if (score >= 5) {
                    yield "Votre niveau de confiance est exceptionnel, vous permettant d'aborder des situations complexes avec assurance et détermination.";
                } else if (score >= 3) {
                    yield "Vous avez une bonne confiance en vous, mais il est possible qu'une situation spécifique vous rende parfois hésitant.";
                } else if (score >= 1) {
                    yield "Votre confiance est modérée. Vous pouvez travailler sur certains aspects pour mieux croire en vos capacités.";
                } else {
                    yield "Votre niveau de confiance est faible. Explorer vos forces et célébrer vos réussites peut renforcer votre estime personnelle.";
                }
            }
            case "Dépression" -> {
                if (score <= -5) {
                    yield "Votre score élevé indique un risque sérieux de dépression. Il est important de consulter un professionnel pour un soutien approprié.";
                } else if (score <= -3) {
                    yield "Vous présentez des symptômes modérés de dépression. Un suivi psychologique ou des changements dans votre quotidien peuvent être bénéfiques.";
                } else if (score <= -1) {
                    yield "Votre score indique une légère dépression, qui pourrait être liée à des événements passagers. Parler à un proche ou un thérapeute pourrait être utile.";
                } else {
                    yield "Vous semblez bien gérer vos émotions et ne présenter aucun signe notable de dépression.";
                }
            }
            default -> "Type de test inconnu. Aucune description disponible.";
        };
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }
}
