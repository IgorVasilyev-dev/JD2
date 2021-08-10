package by.it_academy.jd2.view.api;


import by.it_academy.jd2.model.DiseaseHistory;

import java.util.List;

public interface IDiseaseHistoryView {

    List<DiseaseHistory> getAll();
    DiseaseHistory getDiseaseHistory(Long id);
    List<DiseaseHistory> getDiseaseHistories(DiseaseHistoryFilter filter);
    void addDiseaseHistory(DiseaseHistory diseaseHistory);
    void updateDiseaseHistory(DiseaseHistory diseaseHistory, Long id);
    void deleteDiseaseHistory(Long id);

    class DiseaseHistoryFilter {
        private String login;
        private int page;

        public DiseaseHistoryFilter(String login, int page) {
            this.login = login;
            this.page = page;
        }

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }
    }
}
