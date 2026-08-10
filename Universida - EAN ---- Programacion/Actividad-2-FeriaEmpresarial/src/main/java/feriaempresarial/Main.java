package feriaempresarial;

public class Main {

    public static void main(String[] args) {

        // =====================================================
        // 1. CREAR LA FERIA
        // =====================================================

        FeriaEmpresarial feria = new FeriaEmpresarial(
                "Feria Empresarial 2026"
        );

        System.out.println("========================================");
        System.out.println("     " + feria.obtenerNombreFeria());
        System.out.println("========================================");


        // =====================================================
        // 2. REGISTRAR EMPRESAS
        // =====================================================

        Empresa empresa1 = new Empresa(
                "TechSolutions",
                "Tecnología",
                "contacto@techsolutions.com"
        );

        Empresa empresa2 = new Empresa(
                "Salud Integral",
                "Salud",
                "info@saludintegral.com"
        );

        Empresa empresa3 = new Empresa(
                "EducaPlus",
                "Educación",
                "contacto@educaplus.com"
        );

        feria.registrarEmpresa(empresa1);
        feria.registrarEmpresa(empresa2);
        feria.registrarEmpresa(empresa3);


        // =====================================================
        // 3. REGISTRAR STANDS
        // =====================================================

        Stand stand1 = new Stand(
                1,
                "Pabellón A, Stand 1",
                "Grande"
        );

        Stand stand2 = new Stand(
                2,
                "Pabellón A, Stand 2",
                "Mediano"
        );

        Stand stand3 = new Stand(
                3,
                "Pabellón B, Stand 3",
                "Pequeño"
        );

        Stand stand4 = new Stand(
                4,
                "Pabellón B, Stand 4",
                "Grande"
        );

        feria.registrarStand(stand1);
        feria.registrarStand(stand2);
        feria.registrarStand(stand3);
        feria.registrarStand(stand4);


        // =====================================================
        // 4. ASIGNAR STANDS A EMPRESAS
        // =====================================================

        feria.asignarStand("TechSolutions", 1);
        feria.asignarStand("Salud Integral", 2);
        feria.asignarStand("EducaPlus", 3);


        // =====================================================
        // 5. MOSTRAR STANDS
        // =====================================================

        feria.listarStands();

        feria.mostrarStandsDisponibles();

        feria.mostrarStandsOcupados();


        // =====================================================
        // 6. REGISTRAR VISITANTES
        // =====================================================

        Visitante visitante1 = new Visitante(
                "Sebastian Rodriguez",
                "1001001001",
                "sebastian@gmail.com"
        );

        Visitante visitante2 = new Visitante(
                "Laura Martinez",
                "1002002002",
                "laura@gmail.com"
        );

        Visitante visitante3 = new Visitante(
                "Carlos Gomez",
                "1003003003",
                "carlos@gmail.com"
        );

        feria.registrarVisitante(visitante1);
        feria.registrarVisitante(visitante2);
        feria.registrarVisitante(visitante3);


        // =====================================================
        // 7. MOSTRAR VISITANTES
        // =====================================================

        feria.listarVisitantes();


        // =====================================================
        // 8. REGISTRAR VISITAS A LOS STANDS
        // =====================================================

        feria.registrarVisita("1001001001", 1);
        feria.registrarVisita("1001001001", 2);

        feria.registrarVisita("1002002002", 1);
        feria.registrarVisita("1002002002", 3);

        feria.registrarVisita("1003003003", 2);
        feria.registrarVisita("1003003003", 3);


        // =====================================================
        // 9. AGREGAR COMENTARIOS Y CALIFICACIONES
        // =====================================================

        Comentario comentario1 = new Comentario(
                "Sebastian Rodriguez",
                "10/08/2026",
                5,
                "Excelente atención y muy buenos productos."
        );

        Comentario comentario2 = new Comentario(
                "Laura Martinez",
                "10/08/2026",
                4,
                "Muy buena experiencia."
        );

        Comentario comentario3 = new Comentario(
                "Carlos Gomez",
                "10/08/2026",
                5,
                "Excelente empresa y excelente presentación."
        );

        Comentario comentario4 = new Comentario(
                "Sebastian Rodriguez",
                "10/08/2026",
                3,
                "La información fue interesante."
        );

        Comentario comentario5 = new Comentario(
                "Laura Martinez",
                "10/08/2026",
                4,
                "Muy buen stand."
        );


        // Registrar comentarios en stands específicos
        feria.registrarComentario(1, comentario1);
        feria.registrarComentario(1, comentario2);
        feria.registrarComentario(1, comentario3);

        feria.registrarComentario(2, comentario4);
        feria.registrarComentario(2, comentario5);


        // =====================================================
        // 10. MOSTRAR COMENTARIOS DE LOS STANDS
        // =====================================================

        feria.mostrarComentariosStand(1);

        feria.mostrarComentariosStand(2);

        feria.mostrarComentariosStand(3);


        // =====================================================
        // 11. MOSTRAR REPORTE DE EMPRESAS Y STANDS
        // =====================================================

        feria.reporteEmpresasYStands();


        // =====================================================
        // 12. MOSTRAR REPORTE DE VISITANTES Y STANDS
        // =====================================================

        feria.reporteVisitantesYStands();


        // =====================================================
        // 13. MOSTRAR PROMEDIO DE CALIFICACIONES
        // =====================================================

        feria.reportePromedioCalificaciones();


        // =====================================================
        // 14. GENERAR TODOS LOS REPORTES
        // =====================================================

        feria.generarReportes();


        // =====================================================
        // FIN
        // =====================================================

        System.out.println("\n========================================");
        System.out.println("       FIN DE LA DEMOSTRACIÓN");
        System.out.println("========================================");
    }
}