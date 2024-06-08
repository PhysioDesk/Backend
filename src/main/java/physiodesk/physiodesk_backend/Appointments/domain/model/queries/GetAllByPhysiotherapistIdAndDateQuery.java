package physiodesk.physiodesk_backend.Appointments.domain.model.queries;

public record GetAllByPhysiotherapistIdAndDateQuery(Long physiotherapistId, String date ) {
    public GetAllByPhysiotherapistIdAndDateQuery {
        if (physiotherapistId == null ) {
            throw new IllegalArgumentException("Physiotherapist id must be greater than 0");
        }

        if (date == null || date.isBlank()) {
            throw new IllegalArgumentException("Date cannot be null or empty");
        }

    }
}
