package holdings.indsys.iLabel.Master.ItemSubMaster.UnitOfMeasure;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/api/v1/masters/items/unitOfMeasure")
public class UnitOfMeasureController {


    private final UnitOfMeasureService unitOfMeasureService;
}