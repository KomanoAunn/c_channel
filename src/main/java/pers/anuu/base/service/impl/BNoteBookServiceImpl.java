package pers.anuu.base.service.impl;

import pers.anuu.base.model.BNoteBook;
import pers.anuu.base.mapper.BNoteBookMapper;
import pers.anuu.base.service.IBNoteBookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 记事本表 服务实现类
 * </p>
 *
 * @author anuu
 * @since 2023-01-13
 */
@Service
public class BNoteBookServiceImpl extends ServiceImpl<BNoteBookMapper, BNoteBook> implements IBNoteBookService {

}
