package dev.drf.prog.mockito;

public class FirstService {
    private final SecondService service;

    public FirstService(SecondService service) {
        this.service = service;
    }

    public String type() {
        return "second-service";
    }

    public String calculateType(int number) {
        var type = type();
        return service.calculate(number, type);
    }

    public String calculateDeeply(int from, int to) {
        final var type = type();
        final var fromValue = service.calculate(from, type);
        final var toValue = service.calculate(to, type);

        final var additionalType = service.additionalType();
        final var additionalFromValue = service.calculate(from, additionalType);
        final var additionalToValue = service.calculate(to, additionalType);

        if (fromValue != null && additionalFromValue != null) {
            return additionalFromValue;
        }
        if (toValue != null && additionalToValue != null) {
            return additionalToValue;
        }

        return type;
    }
}
