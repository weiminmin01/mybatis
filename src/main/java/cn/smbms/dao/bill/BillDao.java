package cn.smbms.dao.bill;

import cn.smbms.beans.Bill;
import org.apache.ibatis.annotations.Param;
import sun.awt.image.PNGImageDecoder;

import java.util.List;

public interface BillDao {

    public List<Bill> getBillList(Bill bill);

    public List<Bill> getBillListByNameId(@Param("productName") String productName,
                                          @Param("providerId") Integer providerId,
                                          @Param("isPayment") Integer isPayment);
}
