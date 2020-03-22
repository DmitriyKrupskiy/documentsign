package ds.dataservice;

import java.util.List;

public enum SignProcessState {
    SIGNED("Подписан"),
    SIGNED_BY_FIRST("Подписан первой стороной"),
    CHANGED_AND_SIGNED_BY_SECOND("Изменен и подписан второй стороной"),
    CHANGED_AND_SIGNED_BY_FIRST("Изменен и подписан первой стороной"),
    NOT_SIGNED("Не подписан");

    private String description;

    SignProcessState(String description) {
        this.description = description;
    }

    public static List<SignProcessState> IN_PROCESS_STATES = List.of(SIGNED_BY_FIRST, CHANGED_AND_SIGNED_BY_SECOND, CHANGED_AND_SIGNED_BY_FIRST, SIGNED);
}
