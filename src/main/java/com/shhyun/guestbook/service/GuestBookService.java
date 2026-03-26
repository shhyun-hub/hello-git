package com.shhyun.guestbook.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Sort; // ★ 이 경로여야 합니다!
import org.springframework.stereotype.Service;

import com.shhyun.guestbook.domain.GuestBook;
import com.shhyun.guestbook.repository.GuestBookRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GuestBookService {
  private final GuestBookRepository guestBookRepository;
  
  // 메서드명을 Controller와 맞추기 위해 listBooks로 수정하거나 
  // Controller에서 이 이름을 호출하도록 확인하세요.
  public List<GuestBook> listBooks() throws DataAccessException {
    // Sort.by(Sort.Direction.DESC, "id")가 정상 작동합니다.
    return guestBookRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
  }
  
  public void addPost(GuestBook book) throws DataAccessException {
    guestBookRepository.save(book);
  }
}
