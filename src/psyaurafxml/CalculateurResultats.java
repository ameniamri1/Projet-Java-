package psyaurafxml;

public class CalculateurResultats {

    // Calcule le type de personnalité en fonction des scores
    public TypePersonnalite calculerResultats(int[] scores) {
        if (scores == null || scores.length == 0) {
            throw new IllegalArgumentException("Le tableau des scores ne peut pas être nul ou vide.");
        }

        // Trouve l'index du score maximal
        int maxIndex = 0;
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > scores[maxIndex]) {
                maxIndex = i;
            }
        }

        // Récupère le score maximal
        int maxScore = scores[maxIndex];

        // Génère un type de personnalité basé sur l'index et le score
        return getTypePersonnalite(maxIndex, maxScore);
    }

    // Retourne un type de personnalité basé sur l'index
    private TypePersonnalite getTypePersonnalite(int index, int score) {
        return switch (index) {
            case 0 -> genererPersonnalite("Extraverti", score,
                "Vous aimez interagir avec les autres et êtes souvent plein d'énergie.",
                "Vous êtes très extraverti(e), avec un grand besoin de sociabilité et d'interactions positives.",
                "Vous êtes modérément extraverti(e), ce qui montre un bon équilibre entre sociabilité et moments de réflexion personnelle.",
                "Vous êtes légèrement extraverti(e), préférant des interactions sociales occasionnelles.");
            case 1 -> genererPersonnalite("Introverti", score,
                "Vous préférez des interactions plus calmes et une réflexion interne.",
                "Vous êtes très introverti(e), appréciant les environnements calmes et introspectifs.",
                "Vous êtes modérément introverti(e), ce qui vous permet de vous connecter avec les autres tout en valorisant votre temps seul(e).",
                "Vous êtes légèrement introverti(e), à l'aise dans les interactions sociales tout en préférant des moments calmes.");
            case 2 -> genererPersonnalite("Réaliste", score,
                "Vous êtes pragmatique et vous vous concentrez sur ce qui est pratique.",
                "Vous êtes un(e) réaliste affirmé(e), toujours ancré(e) dans la logique et les faits.",
                "Vous êtes modérément réaliste, capable de combiner une réflexion pratique avec une touche de créativité.",
                "Vous êtes légèrement réaliste, appréciant une approche pratique mais ouvert(e) aux idées innovantes.");
            case 3 -> genererPersonnalite("Idéaliste", score,
                "Vous êtes créatif et optimiste, cherchant à améliorer le monde.",
                "Vous êtes un(e) idéaliste engagé(e), toujours motivé(e) par des visions d'un monde meilleur.",
                "Vous êtes modérément idéaliste, équilibrant vos idéaux avec une approche pragmatique.",
                "Vous êtes légèrement idéaliste, inspiré(e) par des idées innovantes mais restant ancré(e) dans la réalité.");
            default -> new TypePersonnalite("Inconnu", "Le type de personnalité n'a pas pu être déterminé.");
        };
    }

    // Génère une personnalité avec des descriptions adaptées aux plages de scores
    private TypePersonnalite genererPersonnalite(String type, int score, String baseDescription, String haut, String moyen, String bas) {
        String description;
        if (score >= 40) {
            description = haut;
        } else if (score >= 20) {
            description = moyen;
        } else {
            description = bas;
        }
        return new TypePersonnalite(type, description + " " + baseDescription);
    }
}
