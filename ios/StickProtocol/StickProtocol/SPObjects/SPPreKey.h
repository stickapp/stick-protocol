//
//  SPPreKey.h
//  STiiiCK
//
//  Created by Omar Basem on 10/08/2020.
//  Copyright © 2020 STiiiCK. All rights reserved.
//

#import "SPObject.h"

NS_ASSUME_NONNULL_BEGIN

@interface SPPreKey : SPObject

@property (nonatomic) uint32_t keyId;
@property (nonatomic, strong, nullable) NSData *keyData;

- (nullable instancetype)initWithAccountKey:(NSString *)accountKey keyId:(uint32_t)keyId keyData:(nullable NSData *)keyData;

+ (NSString *)uniqueKeyForAccountKey:(NSString *)accountKey keyId:(uint32_t)keyId;

@end

NS_ASSUME_NONNULL_END