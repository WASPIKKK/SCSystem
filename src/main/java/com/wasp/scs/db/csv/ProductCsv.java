package com.wasp.scs.db.csv;

import com.wasp.scs.db.csv.base.EntityCsvManager;

public class ProductCsv extends EntityCsvManager {

    @Override
    protected String getTitle() {
        return String.format("ID%sNAME%sBRAND%sSUPPLIER%s", SEPARATOR, SEPARATOR, SEPARATOR, NEW_LINE);
    }
}
