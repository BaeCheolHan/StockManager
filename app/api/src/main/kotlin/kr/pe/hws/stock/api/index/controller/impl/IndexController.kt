package kr.pe.hws.stock.api.index.controller.impl

import kr.pe.hws.stock.api.index.controller.IndexSpec
import kr.pe.hws.stock.api.index.service.IndexService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class IndexController(val indexService: IndexService) : IndexSpec {

    @GetMapping("/index-chart")
    override fun getIndexChart(chartType: String) {
        indexService.getIndexCharts(chartType)
    }


}
