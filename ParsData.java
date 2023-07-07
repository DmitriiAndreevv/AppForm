import java.util.HashMap;

public class ParsData {
    public HashMap<String, Object> parsInputData() {
        InputData InputData = new InputData();
        String[] data = InputData.en_data();
        HashMap<String, Object> dataDic = new HashMap<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (String i : data) {
            if (i.length() == 1) {
                if (i.equals("f") || i.equals("m")) {
                    dataDic.put("sex", i);
                } else {
                    try {
                        throw new SexException();
                    } catch (SexException e) {
                        e.sexException(i);
                    }
                }
            } else if (i.matches("\\d{1,2}\\.\\d{1,2}\\.\\d{4}")) {
                String[] arrayData = i.split("\\.");
                boolean flag = true;
                if (Integer.parseInt(arrayData[0]) < 0 ||
                        Integer.parseInt(arrayData[0]) > 31 || Integer.parseInt(arrayData[1]) < 0 ||
                        Integer.parseInt(arrayData[1]) > 12 || Integer.parseInt(arrayData[2]) < 0 ||
                        Integer.parseInt(arrayData[1]) > 2023) {
                    try {
                        throw new DataExcept();
                    } catch (DataExcept e) {
                        e.dataException(i);
                    }
                } else {
                    if (Integer.parseInt(arrayData[2]) % 4 == 0) {
                        if (Integer.parseInt(arrayData[1]) == 1 ||
                                Integer.parseInt(arrayData[1]) == 3 ||
                                Integer.parseInt(arrayData[1]) == 5 ||
                                Integer.parseInt(arrayData[1]) == 7 ||
                                Integer.parseInt(arrayData[1]) == 9 ||
                                Integer.parseInt(arrayData[1]) == 10 ||
                                Integer.parseInt(arrayData[1]) == 12) {
                            if (Integer.parseInt(arrayData[0]) < 32) {
                                flag = false;
                            }
                        } else if (Integer.parseInt(arrayData[1]) == 2) {
                            if (Integer.parseInt(arrayData[0]) < 30) {
                                flag = false;
                            }
                        } else if (Integer.parseInt(arrayData[1]) == 4 ||
                                Integer.parseInt(arrayData[1]) == 6 ||
                                Integer.parseInt(arrayData[1]) == 8 ||
                                Integer.parseInt(arrayData[1]) == 11) {
                            if (Integer.parseInt(arrayData[0]) < 31) {
                                flag = false;
                            }
                        }
                    } else {
                        if (Integer.parseInt(arrayData[1]) == 1 ||
                                Integer.parseInt(arrayData[1]) == 3 ||
                                Integer.parseInt(arrayData[1]) == 5 ||
                                Integer.parseInt(arrayData[1]) == 7 ||
                                Integer.parseInt(arrayData[1]) == 9 ||
                                Integer.parseInt(arrayData[1]) == 10 ||
                                Integer.parseInt(arrayData[1]) == 12) {
                            if (Integer.parseInt(arrayData[0]) < 32) {
                                flag = false;
                            }
                        } else if (Integer.parseInt(arrayData[2]) == 2) {
                            if (Integer.parseInt(arrayData[0]) < 29) {
                                flag = false;
                            }
                        } else if (Integer.parseInt(arrayData[1]) == 4 ||
                                Integer.parseInt(arrayData[1]) == 6 ||
                                Integer.parseInt(arrayData[1]) == 8 ||
                                Integer.parseInt(arrayData[1]) == 11) {
                            if (Integer.parseInt(arrayData[0]) < 31) {
                                flag = false;
                            }
                        }

                    }
                    if (!flag) {
                        dataDic.put("data", i);
                    } else try {
                        throw new DataException();
                    } catch (DataException e) {
                        e.dataException(i);
                    }
                }

            } else if (i.matches("[0-9]+")) {
                dataDic.put("tel", i);
            } else if (i.matches("[A-Za-z]+")) {
                stringBuilder.append(i + " ");
            } else {
                try {
                    throw new DataException();
                } catch (DataException e) {
                    e.dataException(i);
                }
            }
        }
        String[] fullName = String.valueOf(stringBuilder).split(" ");
        if (fullName.length == 3) {
            dataDic.put("firstName", fullName[0]);
            dataDic.put("lastName", fullName[1]);
            dataDic.put("patronymic", fullName[2]);
        }
        return dataDic;
    }

}
