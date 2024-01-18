package holdings.indsys.iLabel.BOM;

import holdings.indsys.iLabel.BOM.dao.LineItemDAO;
import holdings.indsys.iLabel.BOM.dao.ProductionBOMDAO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductionBOMService {

    private final ProductionBOMRepository productionBOMRepository;

    private final ModelMapper mapper;
    public List<ProductionBOM> getAll() {
        return productionBOMRepository.findAll();
    }


    public ResponseEntity<?> addNew(ProductionBOM productionBOM) {
        return ResponseEntity.ok(productionBOMRepository.save(productionBOM));
    }

    public ResponseEntity<?> addMany(List<ProductionBOM> productionBOMS) {
        return ResponseEntity.ok(productionBOMRepository.saveAll(productionBOMS));
    }

    public ResponseEntity<?> getProductionBOM(String productionBOMNo) {
        ProductionBOM productionBOM = productionBOMRepository.findByProductionBOMNo(productionBOMNo);
        ProductionBOMDAO productionBOMDAO = mapper.map(productionBOM, ProductionBOMDAO.class);
        return ResponseEntity.ok(productionBOMDAO);
    }

    public ResponseEntity<?> getLineItem(String productionBOMNo) {
        List<LineItem> lineItem = productionBOMRepository.findByProductionBOMNo(productionBOMNo).getLineItems();
        List<LineItemDAO> lineItemDAO = lineItem.stream()
                .map(lineItem1 -> mapper.map(lineItem1, LineItemDAO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(lineItemDAO);
    }


}
