package ra.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.model.domain.Category;
import ra.model.domain.Category;

import ra.model.dto.request.CategoryRequestDto;
import ra.model.dto.response.CategoryResponseDto;
import ra.repository.ICategoryRepository;
import ra.service.IGenericService;
import ra.service.mapper.CategoryMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService  implements IGenericService<CategoryResponseDto, CategoryRequestDto,Long> {
  @Autowired
  private ICategoryRepository categoryRepository;
  @Autowired
  private CategoryMapper categoryMapper;

    @Override
    public List<CategoryResponseDto> findAll() {
        return categoryRepository.findAll().stream()
                .map(c->categoryMapper.toResponse(c)).collect(Collectors.toList());
    }

    @Override
    public CategoryResponseDto findById(Long id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if(categoryOptional.isPresent()) {
            return categoryMapper.toResponse(categoryOptional.get());
        }
        return null;
    }

    @Override
    public CategoryResponseDto save(CategoryRequestDto categoryRequestDto) {
        Category cus = categoryRepository.save(categoryMapper.toEntity(categoryRequestDto));
        return categoryMapper.toResponse(cus);
    }

    @Override
    public CategoryResponseDto update(CategoryRequestDto categoryRequestDto, Long id) {
        Category Category = categoryMapper.toEntity(categoryRequestDto);
        Category.setId(id);
        Category cusEdit = categoryRepository.save(Category);
        return categoryMapper.toResponse(cusEdit);
    }

    @Override
    public CategoryResponseDto delete(Long id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        categoryRepository.delete(categoryOptional.get());
        if(categoryOptional.isPresent()) {
            return categoryMapper.toResponse(categoryOptional.get());
        }
        return null;
    }
}
